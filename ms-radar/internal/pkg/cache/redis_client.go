package cache

import (
	"context"
	"ms-radar/internal/config"
	"sync"
	"time"

	"github.com/go-redis/redis/v8"
	"github.com/joomcode/errorx"
	log "github.com/sirupsen/logrus"
	apmgoredis "go.elastic.co/apm/module/apmgoredisv8/v2"
)

// RedisClient wrapper para redis client
type RedisClient struct{ *redis.Client }

var (
	onceRedisClient sync.Once
	redisClient     *RedisClient
)

// GetRedisClient recupera uma referencia de redis client
func GetRedisClient(cfg *config.Redis) *RedisClient {
	onceRedisClient.Do(func() {
		redisClient = &RedisClient{
			redis.NewClient(&redis.Options{
				Addr: cfg.URL,
				DB:   cfg.Namespace,
			}),
		}
	})

	redisClient.AddHook(apmgoredis.NewHook())

	return redisClient
}

// Ping health check do redis
func (c *RedisClient) Ping(ctx context.Context) *errorx.Error {
	ctx, cancelFunc := context.WithTimeout(ctx, 2*time.Second)
	defer cancelFunc()

	ping, err := c.Client.Ping(ctx).Result()
	if err != nil || ping != "PONG" {
		decorateErr := errorx.Decorate(err, "Não é possível realizar ping no redis")
		log.Warn(decorateErr)
		return decorateErr
	}
	return nil
}

// Flush remove todas as chaves (usado em testes de integração)
func (c *RedisClient) Flush(ctx context.Context) {
	c.Client.FlushAll(ctx)
}

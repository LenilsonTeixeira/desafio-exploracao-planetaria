package cache

import (
	"context"
	"encoding/json"
	"errors"
	"ms-radar/internal/config"
	"ms-radar/internal/model"

	"github.com/labstack/gommon/log"
)

// Get é responsável por recuperar um valor armazenado no cache
func Get(ctx context.Context, key string) (string, error) {
	config := config.Configs.Redis

	redisClient := GetRedisClient(&config)

	val, err := redisClient.Get(ctx, key).Result()

	if err != nil {
		return val, err
	}
	return val, nil
}

// Save é responsável por salvar registros do planeta no cache
func Save(ctx context.Context, p *model.Planet) (*model.Planet, error) {
	config := config.Configs.Redis

	redisClient := GetRedisClient(&config)

	payload, err := json.Marshal(p)

	if err != nil {
		log.Errorf("erro durante o processo de serialização do objeto armazenado no cache. erro: %s", err)
		return nil, errors.New("erro durante o processo de serialização do objeto armazenado no cache")
	}

	key := p.Name

	err = redisClient.Set(ctx, key, payload, config.DefaultTTL).Err()

	if err != nil {
		log.Errorf("ocorreu um erro ao salvar planeta. erro.:", err)
		return nil, err
	}
	return p, nil
}

package config

import "time"

// Redis configuração de cache
type Redis struct {
	URL        string
	Namespace  int
	DefaultTTL time.Duration
}

func (c *configWrapper) getRedisConfig() Redis {
	return Redis{
		URL:        c.GetString("cache.url"),
		Namespace:  c.GetInt("cache.namespace"),
		DefaultTTL: c.getSecondsDuration("cache-default-ttl"),
	}
}

func (c *configWrapper) setRedisDefaults() {
	c.SetDefault("cache.namespace", 2)
	c.SetDefault("cache.default-ttl", 30*86400)
}

package config

import (
	"errors"
	"fmt"
	"log"
	"os"
	"strings"
	"time"

	"github.com/spf13/viper"
)

type Config struct {
	Application
	Logging
	Redis
	Kafka
}

type configWrapper struct{ *viper.Viper }

// Configs referencia de configuração global
var Configs *Config

// Load inicializa o arquivo de configurações
func Load() {
	config := configWrapper{viper.New()}
	config.AddConfigPath("./internal/config")
	config.AddConfigPath("../internal/config")
	config.AddConfigPath("../../internal/config")
	config.AddConfigPath("../config")
	config.AddConfigPath("./source/config")
	config.SetConfigName(getConfigName())

	config.SetConfigType("yaml")

	// Configurações padrão
	config.setDefaults()

	// Configuração de ambiente
	config.SetEnvKeyReplacer(strings.NewReplacer("-", "_", ".", "_"))
	config.AutomaticEnv()

	if err := config.ReadInConfig(); err != nil {
		var configFileNotFoundError viper.ConfigFileNotFoundError
		if ok := errors.Is(err, configFileNotFoundError); !ok {
			log.Fatal("erro ao ler o arquivo de configurações")
		}
	}

	Configs = config.load()
}

func getConfigName() string {
	profile := getProfile()
	if profile != "" {
		return fmt.Sprintf("configuration-%s", strings.ToLower(profile))
	}
	return "configuration"
}

func getProfile() string {
	return os.Getenv("GO_PROFILE")
}

func (c *configWrapper) load() *Config {
	return &Config{
		Application: c.getApplicationConfig(),
		Logging:     c.getLoggingConfig(),
		Redis:       c.getRedisConfig(),
		Kafka:       c.getKafkaConfig(),
	}
}

func (c *configWrapper) setDefaults() {
	c.setApplicationDefaults()
	c.setLoggingDefaults()
	c.setRedisDefaults()
}

func (c *configWrapper) getStringWithFallback(key string, fallback string) string {
	if c.IsSet(key) {
		return c.GetString(key)
	}
	return c.GetString(fallback)
}

func (c *configWrapper) getIntWithFallback(key string, fallback string) int {
	if c.IsSet(key) {
		return c.GetInt(key)
	}
	return c.GetInt(fallback)
}

func (c *configWrapper) getSecondsDurationWithFallback(key string, fallback string) time.Duration {
	if c.IsSet(key) {
		return c.getSecondsDuration(key)
	}
	return c.getSecondsDuration(fallback)
}

func (c *configWrapper) getSecondsDuration(key string) time.Duration {
	return time.Duration(c.GetUint32(key)) * time.Second
}

func (c *configWrapper) getMillisecondsDuration(key string) time.Duration {
	return time.Duration(c.GetUint32(key)) * time.Millisecond
}

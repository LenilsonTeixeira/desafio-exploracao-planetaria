package config

// Logging configurações de log
type Logging struct {
	Level      string
	JSONFormat bool
}

func (c *configWrapper) getLoggingConfig() Logging {
	return Logging{
		Level:      c.GetString("log.level"),
		JSONFormat: c.GetBool("log.json"),
	}
}

func (c *configWrapper) setLoggingDefaults() {
	c.SetDefault("log.level", "INFO")
	c.SetDefault("log.json", false)
}

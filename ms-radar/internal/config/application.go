package config

// Application configuração da aplicação
type Application struct {
	Name string
	Port string
}

func (c *configWrapper) getApplicationConfig() Application {
	return Application{
		Name: c.GetString("application.name"),
		Port: c.GetString("application.port"),
	}
}

func (c *configWrapper) setApplicationDefaults() {
	c.SetDefault("application.name", "ms-radar")
	c.SetDefault("application.port", "8082")
}

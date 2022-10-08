package config

type Kafka struct {
	TopicPlanet     string
	TopicProbe      string
	BootstrapServer string
}

func (c *configWrapper) getKafkaConfig() Kafka {
	return Kafka{
		TopicPlanet:     c.GetString("kafka.topic.ms-planet"),
		TopicProbe:      c.GetString("kafka.topic.ms-probe"),
		BootstrapServer: c.GetString("kafka.bootstrap-server"),
	}
}

func (c *configWrapper) setKafkaDefaults() {
	c.SetDefault("kafka.topic.ms-planet", "planet")
	c.SetDefault("kafka.topic.ms-probe", "probe")
	c.SetDefault("kafka.bootstrap-server", "http://kafka:9092")
}

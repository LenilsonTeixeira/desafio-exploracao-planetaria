package infrastructure

import (
	"context"
	"encoding/json"
	"fmt"
	"ms-radar/internal/config"
	"ms-radar/internal/model"
	"ms-radar/internal/service"

	"github.com/confluentinc/confluent-kafka-go/kafka"
)

func GetKafkaConsumer(cfg *config.Kafka) (*kafka.Consumer, error) {
	return kafka.NewConsumer(&kafka.ConfigMap{
		"bootstrap.servers": cfg.BootstrapServer,
		"group.id":          "ms-planet",
		"auto.offset.reset": "earliest",
	})
}

func PlanetConsumer() {
	config := config.Configs.Kafka
	c, err := GetKafkaConsumer(&config)

	if err != nil {
		panic(err)
	}

	c.SubscribeTopics([]string{"planet"}, nil)

	for {
		msg, err := c.ReadMessage(-1)
		if err == nil {
			fmt.Printf("Recebendo mensagem %s: %s\n", msg.TopicPartition, string(msg.Value))
			var planet model.Planet
			json.Unmarshal(msg.Value, &planet)
			ctx := context.Background()
			service.SavePlanet(ctx, &planet)
			fmt.Println("Planeta salvo com sucesso no cache.")
		} else {
			fmt.Printf("Erro durante o consumo da mensagem: %v (%v)\n", err, msg)
		}
	}

}

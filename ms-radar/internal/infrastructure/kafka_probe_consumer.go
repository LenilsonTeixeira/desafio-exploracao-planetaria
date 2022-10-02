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

func GetKafkaProbeConsumer(cfg *config.Kafka) (*kafka.Consumer, error) {
	return kafka.NewConsumer(&kafka.ConfigMap{
		"bootstrap.servers": cfg.BootstrapServer,
		"group.id":          "ms-probe",
		"auto.offset.reset": "earliest",
	})
}

func ProbeConsumer() {
	config := config.Configs.Kafka
	c, err := GetKafkaProbeConsumer(&config)

	if err != nil {
		panic(err)
	}

	c.SubscribeTopics([]string{"probe"}, nil)

	for {
		msg, err := c.ReadMessage(-1)
		if err == nil {
			fmt.Printf("Recebendo mensagem %s: %s\n", msg.TopicPartition, string(msg.Value))
			var probe model.Probe
			json.Unmarshal(msg.Value, &probe)
			ctx := context.Background()
			service.SaveProbe(ctx, &probe)
			fmt.Println("Sonda salva com sucesso no cache.")
		} else {
			fmt.Printf("Erro durante o consumo da mensagem: %v (%v)\n", err, msg)
		}
	}

}

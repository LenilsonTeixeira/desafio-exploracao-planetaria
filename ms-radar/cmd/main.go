package main

import (
	"ms-radar/internal/config"
	"ms-radar/internal/infrastructure"
	"ms-radar/internal/pkg/logger"
	"ms-radar/internal/routes"

	"github.com/labstack/gommon/log"
)

func main() {
	config.Load()
	logger.Load(config.Configs)

	port := config.Configs.Application.Port
	appName := config.Configs.Application.Name

	log.Infof("%v rodando na porta: %v", appName, port)

	go infrastructure.PlanetConsumer()

	routes.InitRoutes()

}

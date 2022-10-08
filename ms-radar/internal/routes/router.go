package routes

import (
	"ms-radar/internal/api"

	"github.com/gin-gonic/gin"
)

func InitRoutes() {
	router := gin.Default()

	router.GET("/planets/:planet", api.GetPlanet)
	router.GET("/probes/:probe", api.GetProbe)

	router.Run(":8085")
}

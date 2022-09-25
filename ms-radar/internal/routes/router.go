package routes

import (
	"ms-radar/internal/api"

	"github.com/gin-gonic/gin"
)

func InitRoutes() {
	router := gin.Default()

	router.GET("/planets/:planet", api.GetPlanet)
	router.POST("/planets", api.SavePlanet)

	router.Run(":8082")
}

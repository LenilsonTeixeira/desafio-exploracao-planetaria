package routes

import (
	"ms-radar/internal/api"

	"github.com/gin-gonic/gin"
	"go.elastic.co/apm/module/apmgin"
)

func InitRoutes() {
	router := gin.Default()
	router.Use(apmgin.Middleware(router))

	router.GET("/planets/:planet", api.GetPlanet)
	router.GET("/probes/:probe", api.GetProbe)

	router.Run(":8085")

}

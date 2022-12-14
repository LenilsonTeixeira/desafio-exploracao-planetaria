package api

import (
	"ms-radar/internal/service"
	"net/http"

	"github.com/gin-gonic/gin"
)

func GetPlanet(c *gin.Context) {
	key := c.Param("planet")

	resp, err := service.GetPlanetFromCache(c.Request.Context(), key)

	if err != nil {
		c.JSON(http.StatusInternalServerError, err)
	}

	if resp != nil {
		c.JSON(http.StatusOK, resp)
		return
	}

	c.JSON(http.StatusNotFound, "planeta não encontrado")
}

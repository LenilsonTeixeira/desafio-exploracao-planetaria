package api

import (
	"ms-radar/internal/service"
	"net/http"

	"github.com/gin-gonic/gin"
)

func GetProbe(c *gin.Context) {
	key := c.Param("probeInfo")

	resp, err := service.GetPlanetFromCache(c.Request.Context(), key)

	if err != nil {
		c.JSON(http.StatusInternalServerError, err)
	}

	if resp != nil {
		c.JSON(http.StatusOK, resp)
		return
	}

	c.JSON(http.StatusNotFound, "Sonda não encontrada")
}

package api

import (
	"ms-radar/internal/model"
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

func SavePlanet(c *gin.Context) {
	request := model.Planet{}

	err := c.BindJSON(&request)
	if err != nil {
		c.JSON(http.StatusBadGateway, err.Error())
	}

	response, err := service.SavePlanet(c.Request.Context(), &request)

	if err != nil {
		c.JSON(http.StatusInternalServerError, "ocorreu um erro interno ao salvar planeta no cache")
		return
	}

	c.JSON(http.StatusCreated, response)

}

package api

import (
	"errors"
	"ms-radar/internal/exception"

	"github.com/gin-gonic/gin"
)

func ProcessError(c *gin.Context, err error) {
	switch {
	case errors.Is(err, exception.ErrNotFound):
		c.JSON(exception.ErrNotFound.Status, exception.ErrNotFound)
	default:
		c.JSON(exception.ErrInternal.Status, exception.ErrInternal)
	}
}

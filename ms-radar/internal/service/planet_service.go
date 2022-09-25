package service

import (
	"context"
	"encoding/json"
	"ms-radar/internal/model"
	"ms-radar/internal/pkg/cache"
)

// SavePlanet salva planeta no cache por 30 dias
func SavePlanet(ctx context.Context, p *model.Planet) (*model.Planet, error) {
	return cache.Save(ctx, p)
}

// GetPlanetFromCache responsável por buscar informações do planeta no cache
func GetPlanetFromCache(ctx context.Context, planet string) (*model.Planet, error) {
	val, err := cache.Get(ctx, planet)

	if err != nil {
		return nil, nil
	}

	var response model.Planet

	json.Unmarshal([]byte(val), &response)

	if err != nil {
		return nil, err
	}

	return &response, nil
}

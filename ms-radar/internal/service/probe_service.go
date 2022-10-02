package service

import (
	"context"
	"encoding/json"
	"ms-radar/internal/model"
	"ms-radar/internal/pkg/cache"
)

// SaveProbe salva sonda no cache por 30 dias
func SaveProbe(ctx context.Context, p *model.Probe) (*model.Probe, error) {
	return cache.SaveProbe(ctx, p)
}

// GetProbeFromCache responsável por buscar informações da sonda no cache
func GetProbeFromCache(ctx context.Context, probeInfo string) (*model.Probe, error) {
	val, err := cache.GetProbe(ctx, probeInfo)

	if err != nil {
		return nil, nil
	}

	var response model.Probe

	json.Unmarshal([]byte(val), &response)

	if err != nil {
		return nil, err
	}

	return &response, nil
}

package model

type ProbeCoordinate struct {
	LocationX int64 `json:"locationX" validate:"required"`
	LocationY int64 `json:"locationY" validate:"required"`
}

type Probe struct {
	Name            string          `json:"probe" validate:"required"`
	Planet          string          `json:"planet" validate:"required"`
	ProbeCoordinate ProbeCoordinate `json:"probeCoordinate" validate:"required"`
	Status          string          `json:"status" validate:"required"`
}

package model

type ProbeLandingCoordinate struct {
	LocationX int64 `json:"locationX" validate:"required"`
	LocationY int64 `json:"locationY" validate:"required"`
}

type Probe struct {
	Name                   string                 `json:"probe" validate:"required"`
	Planet                 string                 `json:"planet" validate:"required"`
	ProbeLandingCoordinate ProbeLandingCoordinate `json:"probeLandingCoordinate" validate:"required"`
}

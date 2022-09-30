package model

type Planet struct {
	Name                          string `json:"name" validate:"required"`
	CartesianCoordinateSystemArea int    `json:"cartesianCoordinateSystemArea" validate:"required"`
}

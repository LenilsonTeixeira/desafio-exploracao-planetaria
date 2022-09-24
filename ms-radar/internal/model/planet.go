package model

type Planet struct {
	ID                            string `json:"id" validate:"required"`
	Name                          string `json:"name" validate:"required"`
	CartesianCoordinateSystemArea int    `json:"cartesianCoordinateSystemArea" validate:"required"`
}

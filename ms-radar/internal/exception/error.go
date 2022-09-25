package exception

import "net/http"

var (
	ErrNotFound = DictionaryErr{Status: http.StatusNotFound, Message: "not found"}
	ErrInternal = DictionaryErr{Status: http.StatusInternalServerError, Message: "internal error"}
)

type APIError interface {
	// APIError retorna um http status code e uma mensagem de erro
	APIError() (int, string)
}

type DictionaryErr struct {
	Status  int    `json:"status"`
	Message string `json:"message"`
}

func (e DictionaryErr) Error() string {
	return e.Message
}

func (e DictionaryErr) APIError() (int, string) {
	return e.Status, e.Message
}

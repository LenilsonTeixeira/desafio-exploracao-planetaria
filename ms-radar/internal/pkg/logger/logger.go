package logger

import (
	"fmt"
	"ms-radar/internal/config"
	"runtime"
	"strings"

	log "github.com/sirupsen/logrus"
)

// Load responsável por carregar configurações
func Load(config *config.Config) {

	// Tentando realizar parse do nível de log recebido pela configuração
	level, err := log.ParseLevel(config.Logging.Level)
	if err != nil {
		log.Fatal(err)
	}

	log.SetLevel(level)
	log.SetReportCaller(true)

	// estrutura de log
	fields := log.FieldMap{
		log.FieldKeyTime:  "timestamp",
		log.FieldKeyLevel: "level",
		log.FieldKeyMsg:   "message",
	}

	if config.Logging.JSONFormat {
		log.SetFormatter(&log.JSONFormatter{
			FieldMap: fields,
		})
	} else {
		log.SetFormatter(&log.TextFormatter{
			TimestampFormat:        "02-01-2006 15:04:05",
			FullTimestamp:          true,
			ForceColors:            true,
			FieldMap:               fields,
			DisableLevelTruncation: true,
			CallerPrettyfier:       prettifyCaller,
		})
	}

}

func prettifyCaller(f *runtime.Frame) (function string, file string) {
	return "", fmt.Sprintf("%s:%d", formatFilePath(f.File), f.Line)
}

func formatFilePath(path string) string {
	arr := strings.Split(path, "/")
	return arr[len(arr)-1]
}

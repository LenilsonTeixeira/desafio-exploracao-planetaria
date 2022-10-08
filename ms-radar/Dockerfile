# Prepare
FROM golang:1.18.0-alpine AS prepare
WORKDIR /source
COPY go.mod go.sum /source/
RUN apk add build-base
RUN apk add librdkafka-dev pkgconf
RUN go mod download

# Build
FROM prepare AS build
COPY . .
RUN GOOS=linux go build -o bin/ms-radar -tags musl cmd/main.go

# Run
FROM alpine as run
COPY --from=build /source/bin/ms-radar /ms-radar

ADD internal/config ./internal/config

EXPOSE 8085

ENTRYPOINT ["/ms-radar"]
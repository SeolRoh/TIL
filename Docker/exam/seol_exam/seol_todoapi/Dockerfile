FROM golang:1.10

WORKDIR /
ENV GOPATH /go

COPY . /go/src/github.com/gihyodocker/todoapi
RUN go get github.com/go-sql-driver/mysql
RUN go get gopkg.in/gorp.v1
RUN cd /go/src/github.com/gihyodocker/todoapi && go build -o bin/seol_todoapi cmd/main.go
RUN cd /go/src/github.com/gihyodocker/todoapi && cp bin/seol_todoapi /usr/local/bin/

CMD ["seol_todoapi"]

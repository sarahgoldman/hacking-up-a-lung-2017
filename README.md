# hacking-up-a-lung-2017

## API Server
`/app`

## API Configuration
`/api`

### Generating SDKs

To generate the client api sdks:
```
swagger-codegen generate -i api/api.yaml -l typescript-angular -c api/client_config.json -o api/client/
```

To generate the client api sdks:
```
swagger-codegen generate -i api/api.yaml -l java -c api/server_config.json -o api/server/
```


## Public App
`/public`

## Other Assets
`/assets`

### Presentation

### Wireframes

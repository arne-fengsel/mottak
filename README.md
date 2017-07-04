docker build -t fengsel/mottak .
docker run -d -p 4567:4567--name mottak fengsel/mottak



docker rm mottak
docker rmi fengsel/mottak
# mottak

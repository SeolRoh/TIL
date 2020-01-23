FROM node:9.2.0

WORKDIR /seol_todoweb
COPY . /seol_todoweb

RUN npm install -g vue-cli@2.9.3
RUN npm install
RUN npm run build

ENV HOST 0.0.0.0

CMD ["npm", "run", "start"]

EXPOSE 3000

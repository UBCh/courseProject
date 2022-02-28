FROM node:8.16.2-alpine
WORKDIR /home/student/courseProject/gate-simulator/
COPY . .
RUN npm install
CMD ["npm", "start"]
EXPOSE 9999
# nginx state for serving content
FROM nginx:alpine
# Set working directory to nginx asset directory
RUN mkdir -p /app/email-security-frontend/
#WORKDIR /usr/share/nginx/html
WORKDIR /app/email-security-frontend/
# Remove default nginx static assets
#RUN rm -rf ./*
# Copy static assets from builder stage
COPY ./dist .
COPY ./nginx.conf /etc/nginx/nginx.conf
# Containers run nginx with global directives and daemon off
ENTRYPOINT ["nginx", "-g", "daemon off;"]
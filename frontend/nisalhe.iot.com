server {
  listen 80 default_server;
  listen [::]:80 default_server;
  root /var/www/temperature-monitoring-frontend/dist;
  index index.html;
  server_name nisalhe.iot.com www.nisalhe.iot.com;
  location / {
    try_files $uri $uri/ =404;
  }
}

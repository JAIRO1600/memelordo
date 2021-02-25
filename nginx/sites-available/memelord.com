server {	listen 81;
	
	server_name memelord.com;

	root /var/www/memelord.com/public_html;
	index index.php index.html index.htm;
	location / {
		try_files $uri $uri/ =404;
	}
	location ~ \.php$ {
	include snippets/fastcgi-php.conf;
	fastcgi_pass unix:/var/run/php/php7.0-fpm.sock;
	}
	
	location ~ /\.ht{
	deny all;
	}
}

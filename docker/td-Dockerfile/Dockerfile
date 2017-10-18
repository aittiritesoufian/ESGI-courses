FROM alpine:3.6

MAINTAINER soufian <saittirite@myges.fr>

RUN apk --update add openssh && \
	rm -rf /tmp/* ∕var/cache/apk/*

RUN sed -i s/#PermitRootLogin.*/PermitRootLogin\ yes/ /etc/ssh/sshd_config\
	&& echo "root:esgi" | chpasswd

#Generate host keys if not exist
RUN ssh-keygen -A

EXPOSE 22
CMD ["/usr/sbin/sshd","-D", "-e"]

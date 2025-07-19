#
# This is the Dockerfile used to create the the docker image:
# https://hub.docker.com/r/dencee/java-swing-cli
# used in:
# .devcontainer/devcontainer.json
# which is executed when this codespace container boots
#

# Base java environment
FROM mcr.microsoft.com/devcontainers/java:1-21-bullseye

# Get gotty for terminal output to web app
RUN apt-get update && \
    apt-get install -y curl && \
    curl -fL https://github.com/yudai/gotty/releases/download/v1.0.1/gotty_linux_amd64.tar.gz | tar zx -C /usr/local/bin

# Install openbox for swing gui
RUN apt-get update && export DEBIAN_FRONTEND=noninteractive && \
    apt-get -y install --no-install-recommends openbox

# Set openbox to start automatically
RUN echo 'openbox-session &' >> ~/.xinitrc
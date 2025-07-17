# Start from the universal image
FROM mcr.microsoft.com/devcontainers/java

# Get gotty for terminal output to webpage - for some reason doesn't work
RUN apt-get update && \
    apt-get install -y curl && \
    curl -fL https://github.com/yudai/gotty/releases/download/v1.0.1/gotty_linux_amd64.tar.gz | tar zx

# Install openbox
#RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
    && apt-get -y install --no-install-recommends openbox

# Set openbox to start automatically
RUN echo 'openbox-session &' >> ~/.xinitrc
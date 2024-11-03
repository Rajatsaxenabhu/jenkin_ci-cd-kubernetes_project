# Use Fedora as the base image
FROM fedora:40

# Install necessary packages including Maven and Docker
RUN dnf -y update && \
    dnf -y install maven docker && \
    dnf clean all

# Create a Jenkins user and switch to it
RUN useradd -m jenkins && \
    usermod -aG docker jenkins

USER jenkins

# Set the working directory
WORKDIR /home/jenkins

# Expose ports if needed (optional)
# EXPOSE 8080

# Set the entry point
ENTRYPOINT ["/usr/bin/mvn"]

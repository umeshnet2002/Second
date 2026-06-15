FROM maven:3.9.15-eclipse-temurin-21

RUN apt-get update && apt-get install -y
wget
curl
unzip
gnupg
ca-certificates
&& rm -rf /var/lib/apt/lists/*

RUN curl -fsSL https://packages.microsoft.com/keys/microsoft.asc |
gpg --dearmor -o /usr/share/keyrings/microsoft.gpg

RUN echo "deb [arch=amd64 signed-by=/usr/share/keyrings/microsoft.gpg] https://packages.microsoft.com/repos/edge stable main"
> /etc/apt/sources.list.d/microsoft-edge.list

RUN apt-get update &&
apt-get install -y microsoft-edge-stable &&
rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

CMD ["mvn","test","-DsuiteXmlFile=testng.xml"]
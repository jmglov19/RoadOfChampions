FROM mcr.microsoft.com/dotnet/runtime:8.0 AS base
WORKDIR /app

USER app
FROM --platform=$BUILDPLATFORM mcr.microsoft.com/dotnet/sdk:8.0 AS build
ARG configuration=Release
WORKDIR /src
COPY ["csharp/csharp.csproj", "csharp/"]
RUN dotnet restore "csharp/csharp.csproj"
COPY . .
WORKDIR "/src/csharp"
RUN dotnet build "csharp.csproj" -c $configuration -o /app/build

FROM build AS publish
ARG configuration=Release
RUN dotnet publish "csharp.csproj" -c $configuration -o /app/publish /p:UseAppHost=false

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "csharp.dll"]

# docker build -f csharp\Dockerfile -t roadofchampions:test .
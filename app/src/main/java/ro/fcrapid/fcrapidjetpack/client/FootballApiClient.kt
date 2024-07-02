package ro.fcrapid.fcrapidjetpack.client

import java.net.HttpURLConnection
import java.net.URL

class FootballApiClient(apiKey: String) {
    private val baseUrl = "https://api-football-v1.p.rapidapi.com/v3"
    private val apiKeyHeader = "x-rapidapi-key"
    private val apiKeyValue = apiKey

    fun getLeagueTable(leagueId: Int): String {
        val endpoint = "/standings"
        val url = "$baseUrl$endpoint?league_id=$leagueId"
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty(apiKeyHeader, apiKeyValue)

        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            val inputStream = connection.inputStream
            return inputStream.bufferedReader().use { it.readText() }
        } else {
            throw RuntimeException("Failed to fetch league table: ${connection.responseCode}")
        }
    }
}
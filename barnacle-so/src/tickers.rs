use solana_client::client_error::reqwest;

use crate::api_urls::TICKERS;

pub async fn get_all_tokens() -> String {
    reqwest::get(TICKERS).await.unwrap().text().await.unwrap()
}
use barnacle_so::tickers::get_all_tokens;

#[tokio::main]
async fn main() {
    let all_tickers = get_all_tokens().await;

    println!("{}", all_tickers)
}

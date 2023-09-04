use barnacle_so::{currencies::USDC, API_MAINNET};
use solana_client::nonblocking::rpc_client::RpcClient;

#[tokio::main]
async fn main() {
    let client = RpcClient::new(API_MAINNET.to_string());
    println!("{}", USDC.market_cap(&client).await);
}

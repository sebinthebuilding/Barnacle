use barnacle_so::{currencies::{USDC, SOL, MSOL}, API_MAINNET};
use solana_client::nonblocking::rpc_client::RpcClient;

#[tokio::main]
async fn main() {
    let client = RpcClient::new(API_MAINNET.to_string());
    println!("{}", MSOL.market_cap(&client).await);
}

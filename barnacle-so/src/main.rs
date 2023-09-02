use barnacle_so::{rpc_init, API_MAINNET};
use solana_client::nonblocking::rpc_client::RpcClient;

#[tokio::main]
async fn main() {
    let client: RpcClient = rpc_init(API_MAINNET);
    println!("{:#?}", hashmap_all_tokens(&client).await);
}


pub async fn hashmap_all_tokens(client: &RpcClient) {
}
use solana_client::nonblocking::rpc_client::RpcClient;

pub const API_MAINNET: &str = "https://api.mainnet-beta.solana.com";

pub fn rpc_init(endpoint: &str) -> RpcClient {
    let client: RpcClient = RpcClient::new(endpoint.to_string());
    client
}
use barnacle_so::currencies::{USDC, SOL};

#[tokio::main]
async fn main() {

    println!("{}", USDC.ratio(SOL).await);
}
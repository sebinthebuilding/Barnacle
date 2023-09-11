use barnacle_so::math::inverse_volatility;

#[tokio::main]
async fn main() {
    let sol = inverse_volatility().await;
    println!("{}", sol);
}


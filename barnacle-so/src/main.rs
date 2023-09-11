use barnacle_so::math::inverse_volatility;

#[tokio::main]
async fn main() {
    loop {
        let sol: f64 = inverse_volatility().await;
        println!("{}\n", sol);
    }
}


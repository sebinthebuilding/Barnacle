use std::str::FromStr;

use jup_ag::price;
use solana_sdk::pubkey::Pubkey;

pub async fn latest_price_delta() -> f64 {
    let sol_pubkey: Pubkey = Pubkey::from_str("So11111111111111111111111111111111111111112").unwrap();
    let usdc_pubkey: Pubkey = Pubkey::from_str("EPjFWdd5AufqSSqeM2qN1xzybapC8G4wEGGkZwyTDt1v").unwrap();
    
    loop {
        let price1: f64 = price(sol_pubkey, usdc_pubkey, 1.0).await.unwrap().data.price;
        let price2: f64 = price(sol_pubkey, usdc_pubkey, 1.0).await.unwrap().data.price;

        if price1 != price2 {
            println!("{}\n{}", price1, price2);
            return (price1 - price2).abs()
        }
    }
}

pub async fn inverse_volatility() -> f64 {
    1.0 / latest_price_delta().await
}

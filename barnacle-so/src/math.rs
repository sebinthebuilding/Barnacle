use std::str::FromStr;

use jup_ag::price;
use solana_sdk::pubkey::Pubkey;

pub async fn latest_price() -> f64 {
    let sol_pubkey: Pubkey = Pubkey::from_str("So11111111111111111111111111111111111111112").unwrap();
    let usdc_pubkey: Pubkey = Pubkey::from_str("EPjFWdd5AufqSSqeM2qN1xzybapC8G4wEGGkZwyTDt1v").unwrap();

    let price_sol: f64 = price(sol_pubkey, usdc_pubkey, 1.0).await.unwrap().data.price;

    price_sol
}

pub async fn latest_different_prices() -> [f64; 2] {
    loop {
        let price1: f64 = latest_price().await;
        let price2: f64 = latest_price().await;

        if price1 != price2 {
            return [price1, price2];
        }
    }
}

pub async fn latest_price_delta_dollars() -> f64 {
    let last_diff_prices: [f64; 2] = latest_different_prices().await;

    last_diff_prices[0] - last_diff_prices[1]
}

pub async fn latest_price_delta_percent() -> f64 {
    let last_diff_prices: [f64; 2] = latest_different_prices().await;

    ((last_diff_prices[1] - last_diff_prices[0]) / last_diff_prices[0]) * 100.0

}

pub async fn baso_price() {
    let mut vec_dollar_price_delta: Vec<f64> = Vec::new();

    loop {
        vec_dollar_price_delta.push(1.0 / latest_price_delta_dollars().await.abs());

        println!("\n{:#?}\n", vec_dollar_price_delta);

        println!("${}/BASO", get_ave(&vec_dollar_price_delta).await / 100_000.0)
    }
}

async fn get_ave(vector: &Vec<f64>) -> f64 {
    
    vector.iter().sum::<f64>() / vector.len() as f64
}



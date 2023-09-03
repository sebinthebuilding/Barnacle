use std::str::FromStr;

use jup_ag::price;
use solana_sdk::pubkey::Pubkey;

pub struct Currency {
    pub ticker: &'static str,
    pub mint: &'static str,
}

impl Currency {
    pub async fn ratio(self, quote_currency: Currency) -> f64 {
        let base: Pubkey = Pubkey::from_str(self.mint).unwrap();
        let quote: Pubkey = Pubkey::from_str(quote_currency.mint).unwrap();

        let ratio: jup_ag::Response<jup_ag::Price> = price(base, quote, 0.0).await.unwrap();
        
        ratio.data.price
    }

    pub async fn circulating_supply(self) -> f64 {
        0.0
    }

    pub async fn outstanding_market_cap(self) -> f64 {
        0.0
    }
    
}

pub const SOL: Currency = Currency {
    ticker: "SOL",
    mint: "So11111111111111111111111111111111111111112"
};

pub const USDC: Currency = Currency {
    ticker: "USDC",
    mint: "EPjFWdd5AufqSSqeM2qN1xzybapC8G4wEGGkZwyTDt1v"
};

pub const USDT: Currency = Currency {
    ticker: "USDT",
    mint: "Es9vMFrzaCERmJfrF4H2FYD4KCoNkY11McCe8BenwNYB"
};

pub const WBTC: Currency = Currency {
    ticker: "WBTC",
    mint: "3NZ9JMVBmGAqocybic2c7LQCJScmgsAZ6vQqTDzcqmJh"
};

pub const WETH: Currency = Currency {
    ticker: "WETH",
    mint: "7vfCXTUXx5WJV5JADk17DUJ4ksgau7utNKj4b963voxs"
};

pub const MSOL: Currency = Currency {
    ticker: "mSOL",
    mint: "mSoLzYCxHdYgdzU16g5QSh3i5K3z3KZK7ytfqcJm7So"
};

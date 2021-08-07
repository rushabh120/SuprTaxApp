# SuprTaxApp
Low level design for tax calculation application as per instructions attached (Machine Coding)

# Machine Coding Round

Time Limit: 2 hours

# Description
You have to implement a custom service for a billing system that calculates the tax and the
discount on a given product based on the tax slab and discount percentage provided in the
JSON configuration.
- Tax is applied to the product based on the min and max price mentioned in the config
- Tax A will be applied if the price range of the product is greater than 1000 and less than equal to 7500 which is 12% of the price as mentioned in the config below
- Tax B will be applied for all the product where the price is above 7500 and the tax percentage to be 18% on the price
- Tax C will be applied to all the products which are flat 200
- The tax will be applied to each of the product and not on the entire bill
- A bill can have more than one product with different price
- A discount percentage will be applied to the base price

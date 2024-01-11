FROM node:20 as dependencies
WORKDIR /thunderHomeWWW
COPY package.json yarn.lock ./
RUN yarn install --frozen-lockfile

FROM node:20 as builder
WORKDIR /thunderHomeWWW
COPY . .
COPY --from=dependencies /thunderHomeWWW/node_modules ./node_modules
RUN yarn build

FROM node:20 as runner
WORKDIR /thunderHomeWWW
ENV NODE_ENV production

COPY --from=builder /thunderHomeWWW/public ./public
COPY --from=builder /thunderHomeWWW/package.json ./package.json
COPY --from=builder /thunderHomeWWW/.next ./.next
COPY --from=builder /thunderHomeWWW/node_modules ./node_modules

EXPOSE 3000
CMD ["yarn", "start"]
